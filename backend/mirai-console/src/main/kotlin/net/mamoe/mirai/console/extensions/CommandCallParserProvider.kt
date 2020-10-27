/*
 * Copyright 2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package net.mamoe.mirai.console.extensions

import net.mamoe.mirai.console.command.descriptor.ExperimentalCommandDescriptors
import net.mamoe.mirai.console.command.parse.CommandCallParser
import net.mamoe.mirai.console.command.parse.SpaceSeparatedCommandCallParser
import net.mamoe.mirai.console.extension.AbstractInstanceExtensionPoint
import net.mamoe.mirai.console.extension.InstanceExtension

/**
 * The provider of [CommandCallParser]
 */
@ExperimentalCommandDescriptors
public interface CommandCallParserProvider : InstanceExtension<CommandCallParser> {
    public companion object ExtensionPoint :
        AbstractInstanceExtensionPoint<CommandCallParserProvider, CommandCallParser>(CommandCallParserProvider::class,
            SpaceSeparatedCommandCallParser.Provider)
}


@ExperimentalCommandDescriptors
public class CommandCallParserProviderImpl(override val instance: CommandCallParser) : CommandCallParserProvider

@ExperimentalCommandDescriptors
public class CommandCallParserProviderImplLazy(initializer: () -> CommandCallParser) : CommandCallParserProvider {
    override val instance: CommandCallParser by lazy(initializer)
}